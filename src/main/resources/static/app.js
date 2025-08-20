document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("loginForm");
  const card = document.getElementById("loginCard");
  const welcome = document.getElementById("welcome");

  form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const id = document.getElementById("id").value.trim();
    const password = document.getElementById("password").value;

    try {
      const res = await fetch("/api/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ id, password })
      });
      const data = await res.json();

      if (!data.success) {
        // 실패: 팝업으로 사유 표시
        alert(data.message);
        return;
      }

      // 성공: 입력창 제거
      card.remove();

      // "Welcome ID!!!"만 표시 + 폰트 크기 10→100까지 10씩 점점 증가
      welcome.textContent = `Welcome ${data.id}!!!`;
      welcome.style.display = "block";

      let size = 10;                 // 시작 크기
      welcome.style.fontSize = size + "px";

      const timer = setInterval(() => {
        size += 10;                  // 10씩 증가
        if (size > 100) {            // 100을 넘지 않도록 보정
          size = 100;
        }
        welcome.style.fontSize = size + "px";

        if (size >= 100) {
          clearInterval(timer);      // 끝
        }
      }, 180);                       // 증가 간격(ms): 자연스러운 속도로 조정
    } catch (err) {
      alert("로그인 처리 중 오류가 발생했습니다.");
      console.error(err);
    }
  });
});