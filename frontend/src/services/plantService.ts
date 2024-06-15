import axios from "axios";
import { Plant } from "../types";

const API_URL = "http://localhost:8080/api/plants";

export async function savePlant(plant: Plant) {
  return await axios.post(API_URL, plant);
}

export async function getPlants(page = 0, size = 15) {
  return await axios.get(`${API_URL}?page=${page}&size=${size}`);
}

export async function getPlantById(id: number) {
  return await axios.get(`${API_URL}/${id}`);
}

export async function updatePlant(id: number, plant: Plant) {
  return await axios.put(`${API_URL}/${id}`, plant);
}

export async function deletePlant(id: number) {
  return await axios.delete(`${API_URL}/${id}`);
}
