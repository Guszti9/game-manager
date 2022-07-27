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
                    <ParticipantCard data={participant} key={participant.id}>

                    </ParticipantCard>
                )

            })}
        </div>
    );
}

export default ParticipantContainer;