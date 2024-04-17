import { fetchData } from '../../utils';
import type { Category } from '../../Objects/category';
import type { Size } from '../../Objects/size';
import type { Type } from '../../Objects/type';

export async function getAllCategories() {
    const categoryList: Category[] = [];
    const url = 'http://localhost:8080/categories/all';
    const dataCategories = await fetchData(url);

    dataCategories.forEach((dataCategory: any) => {
        const category: Category = {
            id: dataCategory.id,
            label: dataCategory.label
        }

        categoryList.push(category);
    })

    return categoryList;
}

export async function getAllTypes() {
    const typeList: Type[] = [];
    const url = 'http://localhost:8080/types/all';
    const dataTypes = await fetchData(url);

    dataTypes.forEach((dataType: any) => {
        const type: Type = {
            id: dataType.id,
            label: dataType.label
        }

        typeList.push(type);
    })

    return typeList;
}

export async function getAllSizes() {
    const sizeList: Size[] = [];
    const url = 'http://localhost:8080/sizes/all';
    const dataSizes = await fetchData(url);

    dataSizes.forEach((dataSize: any) => {
        const size: Size = {
            id: dataSize.id,
            label: dataSize.label
        }

        sizeList.push(size);
    })

    return sizeList;
}