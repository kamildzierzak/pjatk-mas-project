import { RouterProvider, createBrowserRouter } from "react-router-dom";
import ErrorPage from "./components/errors/ErrorPage";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Layout from "./layouts/Layout";
import Dashboard from "./pages/Dashboard";
import Stocks from "./pages/Stocks";
import Batches from "./pages/Batches";
import AddBatch from "./pages/AddBatch";
import BatchDetails from "./pages/BatchDetails";

const router = createBrowserRouter([
  {
    path: "/",
    errorElement: <ErrorPage />,
    element: <Home />,
  },
  {
    path: "/login",
    errorElement: <ErrorPage />,
    element: <Login />,
  },
  {
    errorElement: <ErrorPage />,
    element: <Layout />,
    children: [
      {
        path: "/dashboard",
        element: <Dashboard />,
      },
      {
        path: "/stocks",
        element: <Stocks />,
      },
      {
        path: "/batches",
        element: <Batches />,
      },
      {
        path: "/batches/create",
        element: <AddBatch />,
      },
      {
        path: "/batches/:batchId",
        element: <BatchDetails />,
      },
    ],
  },
]);

export default function App() {
  return <RouterProvider router={router} fallbackElement={<p>Loading...</p>} />;
}
