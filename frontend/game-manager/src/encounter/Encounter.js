import {dataHandler} from "../data/dataHandler";
import {useState, useEffect} from "react";
import ParticipantCard from "./ParticipantCard";

function Encounter(props) {
    const [encounter, setEncounter] = useState(null)

    useEffect(() => {
        dataHandler.getEncounterById(props.id).then(r => setEncounter(r));
    }, [props]);

    return (
      <div>
          {encounter?.name}
          {encounter?.participants.map(participant => {
              return (
                  <ParticipantCard data={participant} key={participant.id}>
                      {participant.name}
                  </ParticipantCard>
              )

          })}
      </div>
    );
}

export default Encounter;