import {dataHandler} from "../data/dataHandler";
import {useState, useEffect} from "react";

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
                  <div key={participant.id}>
                      {participant.name}
                  </div>
              )

          })}
      </div>
    );
}

export default Encounter;