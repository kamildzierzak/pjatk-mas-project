import axios from "axios";

const API_URL = "http://localhost:8080/api/rows";

export async function getRows() {
  return await axios.get(API_URL);
}

export async function getRowsById(id: number) {
  return await axios.get(`${API_URL}/${id}`);
}
