import { NavLink } from 'react-router-dom';
import logo from '../../images/husky.jpg';
import Search from '../Search/Search.jsx';
import './Header.css';

function Header() {
    return (
        <div className="header">
            <div className="header-left">
                <img src={logo} className="header-logo" alt="logo funky" />
                <div className="title">
                    <h1>Nooky</h1>
                    <p>Échange de la seconde main avec ta communauté</p>
                </div>
            </div>
            <div className="header-right">
                <nav>
                    <NavLink className="menu-left" activeClassName="active" to="/home">Home</NavLink>
                    <NavLink className="menu-left" activeClassName="active" to="/account">Mon compte</NavLink>
                    <NavLink className="menu-left" activeClassName="active" to="/account">Notifications</NavLink>
                    <NavLink className="menu-right" activeClassName="active" to="/login">Log out</NavLink>
                </nav>
                <Search />
            </div>
        </div>
    )
}

export default Header;