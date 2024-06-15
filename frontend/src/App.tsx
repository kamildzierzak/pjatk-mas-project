import { RouterProvider, createBrowserRouter } from "react-router-dom";
import ErrorPage from "./components/errors/ErrorPage";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Layout from "./layouts/Layout";

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
        element: <div>Dashboard</div>,
      },
    ],
  },
]);

export default function App() {
  return <RouterProvider router={router} fallbackElement={<p>Loading...</p>} />;
}
