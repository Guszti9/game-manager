import {useEffect, useState} from "react";
import HealthBar from "./HealthBar";

function ParticipantCard(props) {
    const [participant, setParticipant] = useState(null);

    useEffect(() => {
        setParticipant(props.data);
        console.log(participant);
    }, [props]);


    return (
        <div className="participant-card">
            <div className="participant-data">
                <div>
                    <b>{participant?.name}</b>
                </div>
                <div>
                    <b>INIT:</b> {participant?.init}
                </div>
                <div>
                    <b>AC:</b> {participant?.armorClass}
                </div>
            </div>
            <HealthBar maxHp={participant?.maxHp} currentHp={participant?.currentHp}/>
        </div>
    );
}

export default ParticipantCard;