import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

export default function BatchDetails() {
  const { batchId } = useParams();
  const [batch, setBatch] = useState(null);

  const getBatch = async () => {
    try {
      throw new Error("Not implemented");
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    console.log(batchId);
  }, [batchId]);

  return (
    <div className="flex flex-col gap-8">
      <h1 className="h-20 text-2xl font-bold py-6">Partia</h1>
      <div>{batchId && <div>Partia {batchId} TODO TODO</div>}</div>
    </div>
  );
}
