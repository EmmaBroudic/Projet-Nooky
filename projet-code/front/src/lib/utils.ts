import { goto } from "$app/navigation";

export async function fetchData(url: string): Promise<any> {
    try {
      const response = await fetch(url);
  
      if (!response.ok) {
        throw new Error(`Error fetching data from ${url}`);
      }
  
      return await response.json();
    } catch (error) {
      throw error;
    }
  }

export async function postData(url: string, data: any): Promise<any> {
  
  let token: any;
  token = localStorage.getItem('token');

  if (token != null) {
    try {
      const response = await fetch(url, {
        method: 'POST',
        headers: {
            Accept: 'application/json',
            'authorization': `Bearer ${token}`,
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
      });
        console.log('Data sent');
      } catch (error) {
        console.error('Error posting:', error);
    }
  } else {
    console.log('vous n\'êtes pas authorisé à effectuer cette requête');
  }
  
}

export async function patchData(url: string, data: any): Promise<any> {
  let token: any;
  token = localStorage.getItem('token');

  if (token != null) {
      try {
          const response = await fetch(url, {
              method: 'PATCH',
              headers: {
                  Accept: 'application/json',
                  'Authorization': `Bearer ${token}`,
                  'Content-Type': 'application/json',
              },
              body: JSON.stringify(data)
          });

          console.log('Data patched:');
          return true;
      } catch(error) {
          console.error('Error patching:', error);
          return false;
      }
  } else {
      console.log('vous n\'êtes pas authorisé à effectuer cette requête');
  }
}

export function saveUserId(userId: any) {
  localStorage.setItem('userId', userId);
}

export function getUserId(): any {
  return localStorage.getItem('userId');
}

export function clearUserId() {
  localStorage.removeItem('userId');
  localStorage.removeItem('token');
}

export function tokenBoolean(): boolean {
  const token = localStorage.getItem("token");
  
  if (token === null) {
    return false;
  } else {
    return true;
  }
}