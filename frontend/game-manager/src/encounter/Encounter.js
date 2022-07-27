import {useEffect, useState} from "react";
import {dataHandler} from "../data/dataHandler";
import "./css/encounter.css"
import ParticipantContainer from "./ParticipantContainer";

function Encounter(props) {
    const [encounter, setEncounter] = useState(null)

    useEffect(() => {
        dataHandler.getEncounterById(props.id).then(r => setEncounter(r));
    }, [props]);

    return (
        <div>
            <h2>
                {encounter?.name}
            </h2>
            <ParticipantContainer participants = {encounter?.participants}>

            </ParticipantContainer>


        </div>
    )
}

export default Encounter