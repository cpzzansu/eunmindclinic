import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';
import Sidebar from "./layouts/Sidebar";
import Home from "./pages/Home";
import {useState} from "react";

function App() {
  const [toggle, setToggle] = useState(true);
  const toggleHandler = () => {
    setToggle(!toggle)
  }
  return (
      <div className='container-fluid bg-secondary min-vh-100'>
        <div className='row'>
          {toggle && <div className='col-4 col-md-2 bg-white vh-100 position-fixed'>
            <Sidebar/>
          </div>}
          {toggle && <div className='col-4 col-md-2'></div>}
          <div className='col'>
            <Home toggleHandler={toggleHandler}/>
          </div>
        </div>
      </div>
  );
}

export default App;
