export async function patchUserById(id: number, data: any): Promise<any> {
    let token: any;
    token = localStorage.getItem('token');

    if (token != null) {
        try {
            const response = await fetch(`http://localhost:8080/users/id/${id}`, {
                method: 'PATCH',
                headers: {
                    Accept: 'application/json',
                    'Authorization': `Bearer ${token}`,
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data)
            });
            
            if (!response.ok) {
                throw new Error(`Error patching http://localhost:8080/users/id/${id}`);
            } else {
                console.log('Data patched:');
                return true;
            }
        } catch(error) {
            console.error('Error patching:', error);
            return false;
        }
    } else {
        console.log('vous n\'êtes pas authorisé à effectuer cette requête');
    }
  }