import { fetchData } from '../../utils';
import type { Category } from '../../Objects/category';
import type { Type } from '../../Objects/type';
import type { Size } from '../../Objects/size';

export async function getCategoryByLabel(label:string): Promise<Category> {
    const data = await fetchData(`http://localhost:8080/categories/label/${label}`);

    const category: Category = {
        id: data.id,
        label: data.label,
    }

    return category;
}

export async function getSizeByLabel(label: string): Promise<Size> {
    const data = await fetchData(`http://localhost:8080/sizes/label/${label}`);

    const size: Size = {
        id: data.id,
        label: data.label,
    }

    return size;
}

export async function getTypeByLabel(label: string): Promise<Type> {
    const data = await fetchData(`http://localhost:8080/types/label/${label}`);

    const type: Type = {
        id: data.id,
        label: data.label,
    }

    return type;
}