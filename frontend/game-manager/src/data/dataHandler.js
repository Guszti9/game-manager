const prefix = "http://localhost:8080/"

export let dataHandler = {
    getEncounterById: async function (id) {
        return await apiGet(prefix + `api/encounter/${id}`);
    }
};


async function apiGet(url) {
    let response = await fetch(url, {
        method: "GET"
    });
    if (response.ok) {
        return response.json();
    }
}

export async function apiPost(url, payload) {
    let response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(payload)
    });
    if (response.ok) {
        return response.json();
    }
}

async function apiDelete(url) {
    let response = await fetch(url, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        },
    });
    if (response.ok) {
        return response.json();
    }
}

async function apiPut(url, payload) {
    let response = await fetch(url, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(payload)
    });
    if (response.ok) {
        return response.json();
    }
}