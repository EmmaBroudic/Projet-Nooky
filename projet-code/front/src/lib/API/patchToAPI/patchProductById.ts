export async function patchProductById(id: any, data: any) {
    let token: any;
    token = localStorage.getItem('token');
  
    console.log(token);
    if (token != null) {
        try {
            const response = await fetch(`http://localhost:8080/products/${id}`, {
                method: 'PATCH',
                headers: {
                    Accept: 'application/json',
                    'Authorization': `Bearer ${token}`,
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data)
            });

            console.log('Data patched:');
        } catch(error) {
            console.error('Error patching:', error);
        }
    } else {
        console.log('vous n\'êtes pas authorisé à effectuer cette requête');
    }
}
