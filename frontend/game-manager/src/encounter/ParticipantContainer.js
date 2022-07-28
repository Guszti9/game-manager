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
                    <h2>Add Participant</h2>
                    <button onClick={closeModal}>close</button>
                    <form>
                    </form>
                </Modal>
            </div>
        </div>
    );
}

export default ParticipantContainer;