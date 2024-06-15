import { Link } from "react-router-dom";

export default function Home() {
  return (
    <div className="p-10">
      <div className="w-full flex flex-col justify-center items-center gap-5">
        <h1 className="mt-20 text-6xl font-bold">Witaj w EasyWare!</h1>
        <h2 className="mt-5 text-2xl">
          Najlepszy system do zarządzania magazynem i sprzedażą roślin!
        </h2>
        <Link
          to="login"
          className="btn btn-secondary mt-5 text-lg hover:scale-105"
        >
          Strona logowania
        </Link>
      </div>
    </div>
  );
}
