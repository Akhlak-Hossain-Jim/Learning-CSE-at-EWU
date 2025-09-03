import express from 'express';
import cors from 'cors';
import db from './db';

const app = express();
const port = 3001;

app.use(cors());
app.use(express.json());

// Health check
app.get('/', (req, res) => {
  res.send('API is running!');
});

// Get all tables
app.get('/api/tables', async (req, res) => {
  try {
    const result = await db.query(
      "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public' AND table_name NOT LIKE 'pg_%' AND table_name NOT LIKE 'sql_%' ORDER BY table_name",
      []
    );
    res.json(result.rows.map(row => row.table_name));
  } catch (err) {
    console.error(err);
    res.status(500).json({ error: 'Internal server error' });
  }
});

// Get data from a specific table
app.get('/api/table/:tableName', async (req, res) => {
    const { tableName } = req.params;
    // Basic validation to prevent SQL injection
    if (!/^[a-zA-Z0-9_]+$/.test(tableName)) {
        return res.status(400).json({ error: 'Invalid table name' });
    }
    try {
        const result = await db.query(`SELECT * FROM ${tableName}`, []);
        res.json(result.rows);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Internal server error' });
    }
});


// Get audit history for a specific record
app.get('/api/table/:tableName/:id/history', async (req, res) => {
    const { tableName, id } = req.params;
    const auditTableName = `audit_${tableName}`;
    const primaryKeyCol = `${tableName.slice(0, -1)}_id`;

    if (!/^[a-zA-Z0-9_]+$/.test(tableName) || !/^[a-zA-Z0-9_]+$/.test(auditTableName) || !/^[a-zA-Z0-9_]+$/.test(primaryKeyCol)) {
        return res.status(400).json({ error: 'Invalid table or column name' });
    }

    try {
        const result = await db.query(`SELECT * FROM ${auditTableName} WHERE ${primaryKeyCol} = $1 ORDER BY operation_time DESC`, [id]);
        res.json(result.rows);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Internal server error' });
    }
});

// Add a new record to a table
app.post('/api/table/:tableName', async (req, res) => {
    const { tableName } = req.params;
    const data = req.body;

    if (!/^[a-zA-Z0-9_]+$/.test(tableName)) {
        return res.status(400).json({ error: 'Invalid table name' });
    }

    const columns = Object.keys(data).map(col => `"${col}"`).join(', ');
    const placeholders = Object.keys(data).map((_, i) => `${i + 1}`).join(', ');
    const values = Object.values(data);

    const query = `INSERT INTO "${tableName}" (${columns}) VALUES (${placeholders}) RETURNING *`;

    console.log('Executing query:', query, 'with values:', values);

    try {
        const result = await db.query(query, values);
        res.status(201).json(result.rows[0]);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Internal server error' });
    }
});


app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});
