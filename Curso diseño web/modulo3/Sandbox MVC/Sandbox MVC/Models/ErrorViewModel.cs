namespace Sandbox_MVC.Models
{
    public class ErrorViewModel//modelo para manejar un error aqu� si se hae una llamada directa en error,ya que aqu� no hay interaccion con el usuario ver
    {
        public string? RequestId { get; set; }

        public bool ShowRequestId => !string.IsNullOrEmpty(RequestId);
    }
}