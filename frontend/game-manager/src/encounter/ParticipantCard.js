import {useEffect, useState} from "react";

function ParticipantCard(props) {
    const [participant, setParticipant] = useState(null);

    useEffect(() => {
        setParticipant(props.data);
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

            </div>
        </div>
    );
}

export default ParticipantCard;