import {useState, useEffect} from "react";
import ParticipantCard from "./ParticipantCard";
import Modal from 'react-modal';

const customStyles = {
    content: {
        top: '50%',
        left: '50%',
        right: 'auto',
        bottom: 'auto',
        marginRight: '-50%',
        transform: 'translate(-50%, -50%)',
    },
};


function ParticipantContainer(props) {
    const [participants, setParticipants] = useState(null)
    const [modalIsOpen, setIsOpen] = useState(false);

    useEffect(() => {
        setParticipants(props.participants)
    }, [props]);

    function openModal() {
        setIsOpen(true);
    }

    function closeModal() {
        setIsOpen(false);
    }

    return (
        <div>
            {participants?.map(participant => {
                return (
                    <ParticipantCard data={participant} key={participant.id}/>
                )
            })}
            <div className="add-participant-container">
                <button className="add-participant-button"
                        onClick={openModal}>
                    Add Participant
                </button>
                <Modal
                    isOpen={modalIsOpen}
                    onRequestClose={closeModal}
                    style={customStyles}
                    contentLabel="Example Modal"
                >
                    <div className="modal-header">
                        <h2>Add Participant</h2>
                    </div>
                    <div className="modal-body">
                        <form>

                            <div className="input-div">
                                <input type="text" id="input-name" placeholder=" " required/>
                                <label htmlFor="input-name">Name</label>
                            </div>
                            <div>
                                <div className="input-div">
                                    <input type="number" id="input-init" placeholder=" " required/>
                                    <label htmlFor="input-init">Init</label>
                                </div>
                                <div className="input-div">
                                    <input type="number" id="input-health" placeholder=" " required/>
                                    <label htmlFor="input-health">Health</label>
                                </div>
                                <div className="input-div">
                                    <input type="number" id="input-armor" placeholder=" " required/>
                                    <label htmlFor="input-armor">Armor</label>
                                </div>
                            </div>
                            <div>
                                <label htmlFor="description-input">description</label><br/>
                                <textarea name="description" id="description-input" cols="20" rows="3" required/>
                            </div>
                        </form>
                    </div>
                    <div className="modal-footer">
                        <button onClick={closeModal} className="close-modal-button">close</button>
                        <button
                    </div>
                </Modal>
            </div>
        </div>
    );
}

export default ParticipantContainer;