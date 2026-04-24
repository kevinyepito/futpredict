import './ErrorMessage.css';
export default function ErrorMessage({message}){
    return(
        <div className="error-box">
            <p> {message} ||"ocurrió un error"</p>
            
        </div>
    )
}