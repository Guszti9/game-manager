import * as React from 'react';
import "./registration.css";
import {useState, useEffect} from "react";
import {apiPost} from "../data/dataHandler";
import { useNavigate } from "react-router-dom";

function Registration(){
    const [username, setUsername] = useState(null)
    const [email, setEmail] = useState(null)
    const [password, setPassword] = useState(null)

    const navigate = useNavigate();

    async function handleClick(){
        const payLoad = {
            username: username ? username : null,
            email: email ? email : null,
            password: password ? password : null
        }
        await apiPost("http://localhost:8080/registration", payLoad);
        navigate("http://localhost:8080/login");
    }

    return (
        <div className="registration-form">
            <label>Username</label>
            <input onChange={(e) => setUsername(e.currentTarget.value)} name="username"></input>
            <label>Email</label>
            <input onChange={(e) => setEmail(e.currentTarget.value)} name="email"></input>
            <label>Password</label>
            <input onChange={(e) => setPassword(e.currentTarget.value)}name="password"></input>
            <button onClick={handleClick}><h1>Submit</h1></button>
        </div>
    );
}

export default Registration;