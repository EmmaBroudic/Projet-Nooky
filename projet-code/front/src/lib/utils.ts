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
  try {
    const response = await fetch(url, {
    method: 'POST',
    headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
  },
    body: JSON.stringify(data)
  });

    if (!response.ok) {
      throw new Error('Failed to post');
    }
  } catch (error) {
    console.error('Error posting:', error);
  }
}

export function saveUserId(userId: any) {
  localStorage.setItem('userId', userId);
}

export function getUserId(): any {
  return localStorage.getItem('userId');
}

export function clearUserId(): any {
  return localStorage.removeItem('userId');
}