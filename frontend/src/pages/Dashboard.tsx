const orders = {
  today: {
    toBeRealizedTotal: 1234,
    realized: 1000,
    toBeRealized: 234,
  },
  tommorow: {
    toBeRealizedTotal: 4321,
    realized: 321,
    toBeRealized: 4000,
  },
};

export default function Dashboard() {
  return (
    <div className="flex flex-col gap-8">
      <h1 className="h-20 text-2xl font-bold py-6">Dashboard</h1>
      <div className="flex flex-col gap-8">
        <h2 className="text-xl font-bold">Zamówienia - Dziś</h2>
        <div className="flex flex-col md:flex-row gap-8">
          <div className="w-full flex flex-col gap-2 p-6 border rounded-lg">
            <h3 className="text-lg font-semibold">Do realizacji</h3>
            <div className="text-4xl font-bold">
              {orders.today.toBeRealizedTotal}
            </div>
          </div>
          <div className="w-full flex flex-col gap-2 p-6 border rounded-lg">
            <h3 className="text-lg font-semibold">Zrealizowane</h3>
            <div className="text-4xl font-bold text-primary">
              {orders.today.realized}
            </div>
          </div>
          <div className="w-full flex flex-col gap-2 p-6 border rounded-lg">
            <h3 className="text-lg font-semibold">Do zrealizowania</h3>
            <div className="text-4xl font-bold text-accent">
              {orders.today.toBeRealized}
            </div>
          </div>
        </div>
      </div>
      <div className="flex flex-col gap-8">
        <h2 className="text-xl font-bold">Zamówienia - Jutro</h2>
        <div className="flex flex-col md:flex-row gap-8">
          <div className="w-full flex flex-col gap-2 p-6 border rounded-lg">
            <h3 className="text-lg font-semibold">Do realizacji</h3>
            <div className="text-4xl font-bold">
              {orders.tommorow.toBeRealizedTotal}
            </div>
          </div>
          <div className="w-full flex flex-col gap-2 p-6 border rounded-lg">
            <h3 className="text-lg font-semibold">Zrealizowane</h3>
            <div className="text-4xl font-bold text-primary">
              {orders.tommorow.realized}
            </div>
          </div>
          <div className="w-full flex flex-col gap-2 p-6 border rounded-lg">
            <h3 className="text-lg font-semibold">Do zrealizowania</h3>
            <div className="text-4xl font-bold text-accent">
              {orders.tommorow.toBeRealized}
            </div>
          </div>
        </div>
      </div>
      <div className="flex flex-col gap-8">
        <h2 className="text-xl font-bold">Zamówienia w trakcie realizacji</h2>
        <div className="w-full flex flex-col gap-2 p-6 border rounded-lg"></div>
      </div>
    </div>
  );
}
