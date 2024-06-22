import axios from "axios";

const API_URL = "http://localhost:8080/api/orders";

export async function getOrders() {
  return await axios.get(API_URL);
}

export async function getOrderById(id: number) {
  return await axios.get(`${API_URL}/${id}`);
}
