import './signin.css';

function Signin() {
    return (
        <div className="signin-body">
            <h2>Sign in</h2>
            <form action="/submit" method="post">
                <input type="username" id="username" name="username" placeholder="Entrez votre nom d'utilisateur" required />
                <input type="firstname" id="firstname" name="firstname" placeholder="Entrez votre prénom" required />
                <input type="lastname" id="lastname" name="lastname" placeholder="Entrez votre nom" required />
                <input type="email" id="email" name="email" placeholder="Entrez votre email" required />
                <input type="password" id="password" name="password" placeholder="Entrez votre mot de passe" required />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
}

export default Signin;