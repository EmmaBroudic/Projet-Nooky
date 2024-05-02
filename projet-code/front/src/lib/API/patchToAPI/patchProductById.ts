export async function patchProductById(id: any) {
    try {
        fetch(`http://localhost:8080/products/${id}`,
        {   method: "PATCH",
            headers: {    "Content-type": "application/json"  },
            body: JSON.stringify({    title: "Corrected post"  })})
            .then(response => {    console.log(response.status);     return response.json();  })
            .then(data => console.log(data));
    } catch(error) {
        console.error('Error posting:', error);
    }
}
