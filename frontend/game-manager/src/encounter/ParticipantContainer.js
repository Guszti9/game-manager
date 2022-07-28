import {useState, useEffect} from "react";
import ParticipantCard from "./ParticipantCard";

function ParticipantContainer(props) {
    const [participants, setParticipants] = useState(null)

    useEffect(() => {
        setParticipants(props.participants)
    }, [props]);

    return (
        <div>
            {participants?.map(participant => {
                return (
                    <ParticipantCard data={participant} key={participant.id}/>
                )
            })}
            <div className="add-participant-container">
                <button className="add-participant-button">
                    Add Participant
                </button>
            </div>
        </div>
    );
}

export default ParticipantContainer;