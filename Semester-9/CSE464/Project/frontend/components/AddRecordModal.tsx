import React, { useState, useEffect } from 'react';

interface AddRecordModalProps {
  isOpen: boolean;
  onClose: () => void;
  tableName: string;
  columns: string[];
  onAddRecord: (data: any) => void;
}

const AddRecordModal: React.FC<AddRecordModalProps> = ({ isOpen, onClose, tableName, columns, onAddRecord }) => {
  const [formData, setFormData] = useState<Record<string, any>>({});

  useEffect(() => {
    // Reset form data when modal opens for a new table
    setFormData({});
  }, [isOpen, tableName]);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    onAddRecord(formData);
  };

  if (!isOpen) return null;

  // Filter out columns that should not be manually entered
  const modifiableColumns = columns.filter(col => 
    !col.endsWith('_id') && 
    !col.endsWith('_at') && 
    col !== 'total_amount' && 
    col !== 'line_total'
  );

  return (
    <div className="modal modal-open">
      <div className="modal-box">
        <h3 className="font-bold text-lg">Add New Record to {tableName}</h3>
        <form onSubmit={handleSubmit}>
          <div className="py-4">
            {modifiableColumns.map(column => (
              <div key={column} className="form-control w-full mb-2">
                <label className="label">
                  <span className="label-text">{column}</span>
                </label>
                <input 
                  type="text" 
                  name={column}
                  value={formData[column] || ''}
                  onChange={handleChange}
                  className="input input-bordered w-full" 
                />
              </div>
            ))}
          </div>
          <div className="modal-action">
            <button type="button" className="btn" onClick={onClose}>Cancel</button>
            <button type="submit" className="btn btn-primary">Add Record</button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default AddRecordModal;