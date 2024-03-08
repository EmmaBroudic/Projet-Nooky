import './signup.css';

function Signup() {
    return (
        <div className="signup-body">
            <h2>Sign up</h2>
            <form action="/submit" method="post">
                <input type="email" id="email" name="email" placeholder="Entrez votre email" required />
                <input type="password" id="password" name="password" placeholder="Entrez votre mot de passe" required />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
}

export default Signup;