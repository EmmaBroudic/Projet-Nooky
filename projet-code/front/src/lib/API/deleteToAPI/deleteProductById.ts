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
            return true;
        } catch(error) {
            return false;
        }
    } else {
        return false;
    }
  }