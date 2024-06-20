import { Link } from "react-router-dom";

export default function Login() {
  return (
    <div className="w-screen h-screen flex flex-col">
      <Link to="/" className="p-6 text-xl font-bold">
        EaseWare
      </Link>
      <div className="h-full flex flex-col justify-center items-center">
        <h1 className="text-6xl font-bold">EasyWare</h1>
        <div className="w-full max-w-[400px] flex flex-col gap-6 mt-12">
          <div className="flex flex-col gap-2 text-md font-semibold">
            <label htmlFor="">Login</label>
            <input
              type="text"
              placeholder="Nazwa użytkownika"
              className="p-3 border rounded-lg"
            />
          </div>
          <div className="flex flex-col gap-2 text-md font-semibold">
            <label htmlFor="">Hasło</label>
            <input
              type="password"
              placeholder="**********"
              className="p-3 border rounded-lg"
            />
          </div>
          {/* added Link for test purpouse */}
          <Link to="/dashboard">
            <button className="w-full h-10 text-center bg-black text-white rounded-lg hover:scale-105 hover:bg-black/85 transition-all font-semibold">
              Zaloguj
            </button>
          </Link>
          <div className="divider w-full text-center text-neutral/50">lub</div>
          <button className="w-full h-10 text-center bg-green-500 text-white rounded-lg hover:scale-105 hover:bg-green-500/85 transition-all font-semibold">
            Zarejestruj się
          </button>
        </div>
      </div>
    </div>
  );
}
