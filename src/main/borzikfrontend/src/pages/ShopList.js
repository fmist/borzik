import {useEffect, useState} from "react";
import {Button, Table} from "react-bootstrap";
import {deleteProduct, loadProducts} from "../api/Axios";
import ModalDeleteProduct from "../modals/ModalDeleteProduct";

export default function ShopList() {

    const [posts, setPosts] = useState([])

    useEffect(() => {
        loadProducts(setPosts)
    }, []);

    return (
        <Table striped bordered hover>
            <thead>
            <tr>
                <th>Product</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            {
                posts.map((posts) => (
                    <tr key={posts.id}>
                        <td>{posts.name}</td>
                        <td>{posts.description}</td>
                        <td className="text-right w-25">
                            <Button className="me-2"
                                    variant="primary"
                                    onClick={() => window.location.href = `/edit/${posts.id}`}
                            >Edit
                            </Button>
                            <ModalDeleteProduct OnChange={() => deleteProduct(posts.id)}/>
                        </td>
                    </tr>
                ))
            }
            </tbody>
        </Table>
    );
};