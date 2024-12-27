import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import EmployeeService from '../service/EmployeeService'

const AddEmployee = () => {
    const [employee, setEmployee] = useState({
        id:"",
        firstName:"",
        lastName:"",
        email:"",
    });

    const handleChange = (e) =>{
        const value = e.target.value;
        setEmployee({...employee, [e.target.name]: value})
    }

    const saveEmployee = (e) =>{
        e.preventDefault();
        EmployeeService.saveEmployee(employee)
        .then((response) => {
            console.log("saved ",response);
            navigate("/")
        })
        .catch((error) => {
            console.log(error);
        })
    }

    const reset = (e) =>{
        e.preventDefault();
        setEmployee({
            id:"",
            firstName:"",
            lastName:"",
            email:"",
        });
    }

    const navigate = useNavigate();
  return (
    <div className='max-w-xl mx-40 bg-slate-800 my-20 rounded shadow py-4 px-8'>
        <div className='text-4xl tracking-wider font-bold text-center py-4 px-8'>
             <p>Add 🧑🏼‍💻 New Employee</p>
        </div>

        <div className='mx-10 my-2'>
            <input 
            type='text'
            name="firstName"
            value={employee.firstName}
            onChange={(e)=> handleChange(e)}
            className="w-full py-2 my-4 text-slate-800" placeholder='First-Name'></input>
           
            <input
            type='text'
            name='lastName'
            value={employee.lastName}
            onChange={(e)=> handleChange(e)}
             className="w-full py-2 my-4 text-slate-800" placeholder='Last-Name'></input>
            
            <input 
            type='email'
            name='email'
            value={employee.email}
            onChange={(e)=> handleChange(e)}
            className="w-full py-2 my-4 text-slate-800" placeholder='Email'></input>
        </div>

        <div className='flex my-4 space-x-4 px-20'>
            <button
             onClick={saveEmployee}
            className='bg-green-400 hover:bg-green-700 py-2 px-6 rounded'> Save </button>
            <button 
            onClick={reset}
            className='bg-blue-400 hover:bg-blue-700 py-2 px-6 rounded'>  Clear </button>
            <button 
              onClick={()=> navigate("/")}
              className='bg-red-400 hover:bg-red-700 py-2 px-6 rounded'>  Cancel </button>
        </div>
    </div>
  )
}

export default AddEmployee