import { useState, useEffect } from 'react';
import type { GetServerSideProps, NextPage } from 'next';
import Header from '../components/Header';
import AddRecordModal from '../components/AddRecordModal';

const API_BASE_URL = '/api';

interface HomeProps {
  initialTables: string[];
}

const Home: NextPage<HomeProps> = ({ initialTables }) => {
  const [tables, setTables] = useState<string[]>(initialTables);
  const [selectedTable, setSelectedTable] = useState<string>('');
  const [tableData, setTableData] = useState<any[]>([]);
  const [history, setHistory] = useState<any[]>([]);
  const [isHistoryModalOpen, setIsHistoryModalOpen] = useState(false);
  const [isAddModalOpen, setIsAddModalOpen] = useState(false);

  const fetchTableData = () => {
    if (selectedTable) {
      fetch(`${API_BASE_URL}/table/${selectedTable}`)
        .then((res) => res.json())
        .then((data) => setTableData(data))
        .catch(err => console.error('Error fetching table data:', err));
    }
  }

  useEffect(() => {
    fetchTableData();
  }, [selectedTable]);

  const handleShowHistory = (tableName: string, id: any) => {
    fetch(`${API_BASE_URL}/table/${tableName}/${id}/history`)
      .then((res) => res.json())
      .then((data) => {
        setHistory(data);
        setIsHistoryModalOpen(true);
      })
      .catch(err => console.error('Error fetching history:', err));
  };

  const handleAddRecord = (formData: any) => {
    fetch(`${API_BASE_URL}/table/${selectedTable}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData),
    })
    .then(res => {
      if (!res.ok) {
        throw new Error('Failed to add record');
      }
      return res.json();
    })
    .then(newRecord => {
      console.log('Successfully added record:', newRecord);
      setIsAddModalOpen(false);
      fetchTableData(); // Refresh table data
    })
    .catch(err => console.error('Error adding record:', err));
  };

  const renderTable = () => {
    if (!tableData.length) return <p>No data to display.</p>;

    const headers = Object.keys(tableData[0] || {});

    return (
      <div className="overflow-x-auto">
        <table className="table table-zebra w-full">
          <thead>
            <tr>
              {headers.map((header) => <th key={header}>{header}</th>)}
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {tableData.map((row, rowIndex) => {
              // More robust way to find the primary key for the history button
              const idColumn = headers.find(h => h === `${selectedTable.slice(0, -1)}_id`);
              const id = idColumn ? row[idColumn] : null;

              return (
                <tr key={rowIndex}>
                  {headers.map((header) => <td key={header}>{String(row[header])}</td>)}
                  <td>
                    {id && !selectedTable.startsWith('audit_') && (
                      <button 
                        className="btn btn-xs btn-primary"
                        onClick={() => handleShowHistory(selectedTable, id)}
                      >
                        History
                      </button>
                    )}
                  </td>
                </tr>
              )
            })}
          </tbody>
        </table>
      </div>
    );
  };

  const renderHistoryModal = () => {
    if (!isHistoryModalOpen) return null;

    const headers = Object.keys(history[0] || {});

    return (
        <div className="modal modal-open">
            <div className="modal-box w-11/12 max-w-5xl">
                <h3 className="font-bold text-lg">Record History</h3>
                <div className="overflow-x-auto">
                    <table className="table table-zebra w-full mt-4">
                        <thead>
                            <tr>
                                {headers.map(header => <th key={header}>{header}</th>)}
                            </tr>
                        </thead>
                        <tbody>
                            {history.map((record, index) => (
                                <tr key={index}>
                                    {headers.map(header => <td key={header}>{String(record[header])}</td>)}
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
                <div className="modal-action">
                    <button className="btn" onClick={() => setIsHistoryModalOpen(false)}>Close</button>
                </div>
            </div>
        </div>
    );
};


  return (
    <div className="min-h-screen bg-base-200" data-theme="light">
      <Header />
      <main className="p-4">
        <div className="card bg-base-100 shadow-xl">
          <div className="card-body">
            <div className="form-control w-full max-w-xs mb-4">
              <label className="label">
                <span className="label-text">Select a Table</span>
              </label>
              <select 
                className="select select-bordered"
                value={selectedTable}
                onChange={(e) => setSelectedTable(e.target.value)}
              >
                <option disabled value="">-- Select --</option>
                {tables.map((table) => (
                  <option key={table} value={table}>{table}</option>
                ))}
              </select>
            </div>

            {selectedTable && (
              <div>
                <div className="flex justify-between items-center mb-2">
                  <h2 className="card-title">Data for: {selectedTable}</h2>
                  <button 
                    className="btn btn-primary"
                    onClick={() => setIsAddModalOpen(true)}
                    disabled={selectedTable.startsWith('audit_')}
                  >
                    Add New Record
                  </button>
                </div>
                {renderTable()}
              </div>
            )}
          </div>
        </div>
      </main>
      {renderHistoryModal()}
      <AddRecordModal 
        isOpen={isAddModalOpen}
        onClose={() => setIsAddModalOpen(false)}
        tableName={selectedTable}
        columns={Object.keys(tableData[0] || {})}
        onAddRecord={handleAddRecord}
      />
    </div>
  );
};

export const getServerSideProps: GetServerSideProps = async () => {
  try {
    // Use the full internal Docker network URL for server-side fetch
    const res = await fetch(`http://api:3001/api/tables`);
    if (!res.ok) throw new Error('Failed to fetch');
    const initialTables = await res.json();
    return { props: { initialTables } };
  } catch (error) {
    console.error('Error in getServerSideProps:', error);
    return { props: { initialTables: [] } };
  }
};

export default Home;
