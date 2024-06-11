import { useRouteError } from "react-router-dom";

export default function ErrorPage() {
  const error = useRouteError();

  return (
    <div
      id="error"
      className="w-full flex flex-col justify-center items-center gap-5"
    >
      <h1 className="text-3xl mt-10">Error!</h1>
      <p className="text-xl">{error.statusText || error.message}</p>
    </div>
  );
}
