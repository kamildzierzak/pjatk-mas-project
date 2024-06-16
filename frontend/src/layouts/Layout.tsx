import { useState } from "react";
import { Link, Outlet } from "react-router-dom";
import { BsHouse, BsSearch, BsListCheck, BsListTask } from "react-icons/bs";

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
  return (
    <div className="h-full max-w-screen-2xl flex mx-auto ">
      <div className="hidden min-h-lvh lg:flex min-w-64 border-x-2">
        <div className="w-full flex flex-col text-md font-semibold">
          <Link to="/dashboard" className="h-20 text-2xl font-bold p-6">
            EaseWare
          </Link>
          <div className="mt-6 font-semibold">
            <h2 className="px-4 py-2 font-bold">Główne</h2>
            <ul className="flex flex-col gap-1">
              {mainNavLinks.map(link => (
                <li key={link.href} className="px-4 py-2">
                  <Link
                    to={link.href}
                    className="w-full flex items-center gap-4"
                  >
                    {link.icon ? <link.icon /> : <span className="w-4"></span>}
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
                <li key={link.href} className="px-4 py-2">
                  <Link
                    to={link.href}
                    className="w-full flex items-center gap-4"
                  >
                    {link.icon ? <link.icon /> : <span className="w-4"></span>}
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
                <li key={link.href} className="px-4 py-2">
                  <Link
                    to={link.href}
                    className="w-full flex items-center gap-4"
                  >
                    {link.icon ? <link.icon /> : <span className="w-4"></span>}
                    {link.name}
                  </Link>
                </li>
              ))}
            </ul>
          </div>
        </div>
      </div>
      <div className="w-full min-h-lvh px-6 border-r-2">
        <Outlet />
      </div>
    </div>
  );
}
