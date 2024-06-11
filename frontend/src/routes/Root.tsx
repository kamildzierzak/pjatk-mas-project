import { Link, useOutlet } from "react-router-dom";
import Home from "./Home";

const navigationLinks = [
  { name: "Home", href: "/" },
  { name: "Dashboard", href: "/dashboard" },
  { name: "Plants", href: "/plants" },
];

export default function Root() {
  const outlet = useOutlet();

  return (
    <div className="max-w-screen-2xl mx-auto p-5">
      <div className="flex flex-col gap-5">
        <nav className="p-5 border flex flex-col gap-3">
          <div>
            <h1 className="text-xl font-semibold">
              <Link to="/">WarManSystem</Link>
            </h1>
          </div>
          <ul className="flex lg:hidden flex-col gap-1">
            {navigationLinks.map(link => (
              <li key={link.href}>
                <Link to={link.href}>{link.name}</Link>
              </li>
            ))}
          </ul>
        </nav>
        <div className="min-h-lvh w-full flex gap-5">
          <div className="min-w-[200px] hidden lg:flex flex-col gap-5 py-10 px-5 border">
            <ul className="flex flex-col gap-1">
              {navigationLinks.map(link => (
                <li key={link.href}>
                  <Link to={link.href}>{link.name}</Link>
                </li>
              ))}
            </ul>
          </div>
          <div className="w-full py-10 px-5 border">{outlet || <Home />}</div>
        </div>
      </div>
    </div>
  );
}
