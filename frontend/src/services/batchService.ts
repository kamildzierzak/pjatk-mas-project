import axios from "axios";
import { Batch } from "../types";

const API_URL = "http://localhost:8080/api/batches";

export async function getBatches(page = 0, size = 10) {
  return await axios.get(`${API_URL}?page=${page}&size=${size}`);
}

export async function getBatchtById(id: number) {
  return await axios.get(`${API_URL}/${id}`);
}

export async function saveBatch(batch: Batch) {
  return await axios.post(API_URL, batch);
}

export async function updateBatch(id: number, batch: Batch) {
  return await axios.put(`${API_URL}/${id}`, batch);
}

export async function deleteBatch(id: number) {
  return await axios.delete(`${API_URL}/${id}`);
}
