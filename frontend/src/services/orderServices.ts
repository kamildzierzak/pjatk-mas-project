import axios from "axios";

const API_URL = "http://localhost:8080/api/orders";

export async function getOrders() {
  return await axios.get(API_URL);
}

export async function getOrderById(id: number) {
  return await axios.get(`${API_URL}/${id}`);
}

export async function moveBatchToShelf(
  orderId: number,
  batchId: number,
  shelfId: number,
  pricePerItem: number,
  quantity: number
) {
  return await axios.post(
    `${API_URL}/moveBatch?orderId=${orderId}&batchId=${batchId}&shelfId=${shelfId}&pricePerItem=${pricePerItem}&quantity=${quantity}`
  );
}
