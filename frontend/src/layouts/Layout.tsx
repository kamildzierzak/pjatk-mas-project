import { useState } from "react";
import { Link, Outlet } from "react-router-dom";
import {
  BsHouse,
  BsSearch,
  BsListCheck,
  BsListTask,
  BsList,
} from "react-icons/bs";

const mainNavLinks = [
  {
    name: "Dashboard",
    href: "/dashboard",
    icon: BsHouse,
  },
  { name: "Szukaj", href: "/search", icon: BsSearch },
  { name: "Asortyment", href: "/stocks", icon: BsListCheck },
];

const storageNavLinks = [
  { name: "Rzędy", href: "/rows", icon: BsListTask },
  { name: "Regały", href: "/racks", icon: BsListTask },
  { name: "Półki", href: "/shelves", icon: BsListTask },
  { name: "Partie", href: "/batches", icon: BsListTask },
];

const ordersNavLinks = [
  {
    name: "Klienci",
    href: "/customers",
    icon: BsListTask,
  },
  {
    name: "Dostawcy",
    href: "/suppliers",
    icon: BsListTask,
  },
  {
    name: "Raporty",
    href: "/reports",
    icon: BsListTask,
  },
];

export default function Layout() {
  const [isMenuOpen, setIsMenuOpen] = useState(true);

  return (
    <div className="h-full max-w-screen-2xl flex flex-col lg:flex-row mx-auto ">
      {/* Navigation >= 1024px */}
      {isMenuOpen ? (
        <div className="hidden min-h-lvh lg:flex min-w-64 border-x-2 ">
          <div className="w-full flex flex-col text-md font-semibold">
            <div className="h-20 flex justify-between text-2xl font-bold p-6">
              <Link
                to="/dashboard"
                className="hover:scale-105 hover:text-primary transition-all"
              >
                EaseWare
              </Link>
              <button
                onClick={() => setIsMenuOpen(!isMenuOpen)}
                className="hover:scale-110 hover:text-primary transition-all"
              >
                <BsList size={24} />
              </button>
            </div>
            <div className="mt-6 font-semibold">
              <h2 className="px-4 py-2 font-bold">Główne</h2>
              <ul className="flex flex-col gap-1">
                {mainNavLinks.map(link => (
                  <li
                    key={link.href}
                    className="px-4 py-2 hover:bg-primary transition-all"
                  >
                    <Link
                      to={link.href}
                      className="w-full flex items-center gap-4"
                    >
                      {link.icon ? (
                        <link.icon />
                      ) : (
                        <span className="w-4"></span>
                      )}
                      {link.name}
                    </Link>
                  </li>
                ))}
              </ul>
            </div>
            <div className="mt-6 font-semibold">
              <h2 className="px-4 py-2 font-bold">Magazyn</h2>
              <ul className="flex flex-col gap-1">
                {storageNavLinks.map(link => (
                  <li
                    key={link.href}
                    className="px-4 py-2 hover:bg-primary transition-all"
                  >
                    <Link
                      to={link.href}
                      className="w-full flex items-center gap-4"
                    >
                      {link.icon ? (
                        <link.icon />
                      ) : (
                        <span className="w-4"></span>
                      )}
                      {link.name}
                    </Link>
                  </li>
                ))}
              </ul>
            </div>
            <div className="mt-6 font-semibold">
              <h2 className="px-4 py-2 font-bold">Zamówienia</h2>
              <ul className="flex flex-col gap-1">
                {ordersNavLinks.map(link => (
                  <li
                    key={link.href}
                    className="px-4 py-2 hover:bg-primary transition-all"
                  >
                    <Link
                      to={link.href}
                      className="w-full flex items-center gap-4"
                    >
                      {link.icon ? (
                        <link.icon />
                      ) : (
                        <span className="w-4"></span>
                      )}
                      {link.name}
                    </Link>
                  </li>
                ))}
              </ul>
            </div>
          </div>
        </div>
      ) : (
        <div className="hidden lg:block p-6 border-r-2">
          <button
            onClick={() => setIsMenuOpen(!isMenuOpen)}
            className="hover:scale-110 hover:text-primary"
          >
            <BsList size={24} />
          </button>
        </div>
      )}
      {/* Mobile Navigation < 1024 */}
      {isMenuOpen ? (
        <div className="lg:hidden min-h-32 p-6 border-b-2 border-primary">
          <div className="flex justify-end pb-6 border-b-2">
            <button
              onClick={() => setIsMenuOpen(!isMenuOpen)}
              className="hover:scale-110 hover:text-primary transition-all"
            >
              <BsList size={24} />
            </button>
          </div>
          <div className="flex flex-col md:flex-row gap-8">
            <div className="w-full px-6 mt-6 font-semibold">
              <h2 className="px-4 py-2 font-bold">Główne</h2>
              <ul className="flex flex-col gap-1">
                {mainNavLinks.map(link => (
                  <li
                    key={link.href}
                    className="px-4 py-2 hover:bg-primary transition-all"
                  >
                    <Link
                      to={link.href}
                      className="w-full flex items-center gap-4"
                    >
                      {link.icon ? (
                        <link.icon />
                      ) : (
                        <span className="w-4"></span>
                      )}
                      {link.name}
                    </Link>
                  </li>
                ))}
              </ul>
            </div>
            <div className="w-full px-6 mt-6 font-semibold">
              <h2 className="px-4 py-2 font-bold">Magazyn</h2>
              <ul className="flex flex-col gap-1">
                {storageNavLinks.map(link => (
                  <li
                    key={link.href}
                    className="px-4 py-2 hover:bg-primary transition-all"
                  >
                    <Link
                      to={link.href}
                      className="w-full flex items-center gap-4"
                    >
                      {link.icon ? (
                        <link.icon />
                      ) : (
                        <span className="w-4"></span>
                      )}
                      {link.name}
                    </Link>
                  </li>
                ))}
              </ul>
            </div>
            <div className="w-full px-6 mt-6 font-semibold">
              <h2 className="px-4 py-2 font-bold">Zamówienia</h2>
              <ul className="flex flex-col gap-1">
                {ordersNavLinks.map(link => (
                  <li
                    key={link.href}
                    className="px-4 py-2 hover:bg-primary transition-all"
                  >
                    <Link
                      to={link.href}
                      className="w-full flex items-center gap-4"
                    >
                      {link.icon ? (
                        <link.icon />
                      ) : (
                        <span className="w-4"></span>
                      )}
                      {link.name}
                    </Link>
                  </li>
                ))}
              </ul>
            </div>
          </div>
        </div>
      ) : (
        <div className="lg:hidden p-6 border-b-2 border-primary">
          <div className="flex justify-end">
            <button
              onClick={() => setIsMenuOpen(!isMenuOpen)}
              className="hover:scale-110 hover:text-primary transition-all "
            >
              <BsList size={24} />
            </button>
          </div>
        </div>
      )}
      {/* Content area */}
      <div className="w-full min-h-lvh px-6 border-r-2">
        <Outlet />
      </div>
    </div>
  );
}
