import {useState, useEffect} from "react";

function HealthBar(props) {
    const [maxHp, setMaxHp] = useState(null);
    const [currentHp, setCurrentHp] = useState(null);
    const [percentage, setPercentage] = useState(null);

    useEffect(() => {
        setMaxHp(props.maxHp);
        setCurrentHp(props.currentHp);
        setPercentage((props.currentHp * 100) / props.maxHp );
    }, [props])

    return (
        <div className="health-bar"
             style={{backgroundImage: `linear-gradient(to right, #895061 0% ${percentage}%, transparent ${percentage}% 100%)`}}>
            <p className="health-value">{currentHp} / {maxHp}</p>
        </div>
    );
}


export default HealthBar;