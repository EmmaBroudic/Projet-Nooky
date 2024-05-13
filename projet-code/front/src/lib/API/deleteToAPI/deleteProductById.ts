export async function deleteProductById(id: any): Promise<any> {
    let token: any;
    token = localStorage.getItem('token');
  
    if (token != null) {
        try {
            const response = await fetch(`http://localhost:8080/products/${id}`, {
                method: 'DELETE',
                headers: {
                    Accept: 'application/json',
                    'Authorization': `Bearer ${token}`,
                    'Content-Type': 'application/json',
                },
            });
  
            console.log('Data deleted:');
            return true;
        } catch(error) {
            console.error('Error patching:', error);
            return false;
        }
    } else {
        console.log('vous n\'êtes pas authorisé à effectuer cette requête');
    }
  }