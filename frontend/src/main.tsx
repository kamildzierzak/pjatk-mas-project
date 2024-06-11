import React from "react";
import ReactDOM from "react-dom/client";
import Root from "./routes/Root.tsx";
import "./index.css";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import ErrorPage from "./ErrorPage.tsx";
import Plants from "./components/Plants.tsx";
import Dashboard from "./routes/Dashboard.tsx";

// moccup
const data = {
  content: [
    { id: 1, name: "Plant 1" },
    { id: 2, name: "Plant 2" },
    { id: 3, name: "Plant 3" },
  ],
};

const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "dashboard",
        element: <Dashboard />,
      },
      {
        path: "plants",
        element: <Plants data={data} />,
      },
    ],
  },
]);

ReactDOM.createRoot(document.getElementById("root")!).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
