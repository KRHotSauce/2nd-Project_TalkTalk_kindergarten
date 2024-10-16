/* document.querySelector(".menu_drop_down").addEventListener("mouseenter", () => {
  document.querySelector(".top_nav_drop").classList.add("slide_down");
});

document.querySelector(".menu_drop_down").addEventListener("mouseleave", () => {
  document.querySelector(".top_nav_drop").classList.remove("slide_down");
}); */
$(document).ready(function() {
  const div1 = document.querySelector(".top_nav_navbar_menu");
  const div2 = document.querySelector(".top_nav_drop");

  // 마우스가 div1에 들어가면 div2에 클래스를 추가
  div1.addEventListener("mouseenter", () => {
    div2.classList.add("slide_down");
  });

  // 마우스가 div1을 나가면 확인: div2로 이동 중인지 확인
  div1.addEventListener("mouseleave", (event) => {
    const relatedTarget = event.relatedTarget;

    // 만약 관련된 요소가 div2가 아니라면 (div2로 이동하지 않았다면)
    if (!div2.contains(relatedTarget)) {
      div2.classList.remove("slide_down");
    }
  });

  // div2에서 나가면, 마우스가 div1과 div2 모두 벗어났을 때 클래스를 제거
  div2.addEventListener("mouseleave", (event) => {
    const relatedTarget = event.relatedTarget;

    // 만약 관련된 요소가 div1이 아니라면 (div1로 이동하지 않았다면)
    if (!div1.contains(relatedTarget)) {
      div2.classList.remove("slide_down");
    }
  });

  const div3 = document.querySelector(".top_nav_user_box");
  const div4 = document.querySelector(".top_nav_user_info");

  div3.addEventListener("mouseenter", () => {
      div4.classList.add("slide_down")
  });

  div3.addEventListener("mouseleave", () => {
      div4.classList.remove("slide_down")
  });
});
