import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

const Menubar = () => {
    return (
        <Navbar bg="dark" data-bs-theme="dark">
            <Container>
                <Navbar.Brand href="/">Bo</Navbar.Brand>
                <Nav className="me-4">
                    <Nav.Link href="/">Bo's</Nav.Link>
                    <Nav.Link href="/add">New bo</Nav.Link>
                    <Nav.Link href="http://localhost:8081/swagger" rel="noopener noreferrer" target="_blank">Swagger</Nav.Link>
                    <Nav.Link href="http://localhost:8081/api" rel="noopener noreferrer" target="_blank">Api</Nav.Link>
                    <Nav.Link href="/about">About</Nav.Link>
                </Nav>
            </Container>
        </Navbar>
    );
}
export default Menubar;