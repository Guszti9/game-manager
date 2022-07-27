import {useEffect, useState} from "react";
import HealthBar from "./HealthBar";

function ParticipantCard(props) {
    const [participant, setParticipant] = useState(null);

    useEffect(() => {
        setParticipant(props.data);
        console.log(participant);
    }, [props]);


    return (
        <div className="card">
            <div className="cardBody">
                <div>
                    {participant?.name}
                </div>
                <div>
                    {participant?.init}
                </div>

                <HealthBar maxHp={participant?.maxHp} currentHp={participant?.currentHp}/>
            </div>
        </div>
    );
}

export default ParticipantCard;