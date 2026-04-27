<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@include file="/common/taglib.jsp" %>
    <c:url var="animeURL" value="/item-anime" />
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html lang="vi">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Anime Detail</title>
      <script src="<c:url value='/template/web/css/itemanime.css' />"></script>
    </head>

    <body>
      <!-- Product section-->
      <section class="py-5">
        <div class="container px-4 px-lg-5 my-5">
          <div class="row gx-4 gx-lg-5 align-items-center">
            <!-- Ảnh đại diện -->
            <div class="col-md-6">
              <img class="card-img-top mb-5 mb-md-0" src="${model.thumbnail}" alt="${model.title}" />
            </div>

            <div class="col-md-6">
              <!-- Tiêu đề -->
              <h2 class="fw-bold mb-3">${model.title}</h2>

              <!-- Bảng thông tin -->
              <table class="table table-dark table-striped">
                <tr>
                  <td><strong>Thể loại</strong></td>
                  <td>
                    <c:forEach var="item" items="${model.categoryModels}">
                      <span class="badge bg-info">${item.name}</span>
                    </c:forEach>
                  </td>
                </tr>
                <tr>
                  <td><strong>Quốc gia</strong></td>
                  <td>${model.country}</td>
                </tr>
                <tr>
                  <td><strong>Trạng thái</strong></td>
                  <td>${model.status}</td>
                </tr>
                <tr>
                  <td><strong>Số tập</strong></td>
                  <td>${model.episodes}</td>
                </tr>
                <tr>
                  <td><strong>Phát hành</strong></td>
                  <td>${model.releaseYear}</td>
                </tr>
                <tr>
                  <td><strong>Đánh giá</strong></td>
                  <td>${model.rating}</td>
                </tr>
                <tr>
                  <td><strong>Mô tả ngắn</strong></td>
                  <td>${model.shortDescription}</td>
                </tr>
              </table>
            </div>
          </div>
        </div>
      </section>
      <!-- Section Nội dung -->
      <section class="mt-4 p-4 rounded" style="background-color:#f8f9fa; border:1px solid #dee2e6;">
        <h3 class="fw-bold mb-3" style="color:#343a40;">Nội dung</h3>
        <div style="white-space: pre-line; line-height: 1.8; color:#212529; font-size: 1rem;">
          ${model.content}
        </div>
      </section>

      <!-- Section Bình luận -->
      <section class="mt-4 p-4 rounded" style="background-color:#ffffff; border:1px solid #dee2e6;">
        <h3 class="fw-bold mb-3" style="color:#343a40;">Bình luận</h3>

        <!-- Khung chứa danh sách bình luận -->
        <div style="max-height:300px; overflow-y:auto;">
          <c:forEach var="comment" items="${commentModels}">
            <div class="mb-3 p-3 border rounded">
              <p class="mb-1"><strong>${comment.userFullName}</strong>:</p>
              <p style="white-space: pre-line;">${comment.content}</p>
            </div>
          </c:forEach>
        </div>

        <!-- Form thêm bình luận -->
        <form action="<c:url value='/comment-add'/>" method="post" accept-charset="UTF-8">
          <input type="hidden" name="animeId" value="${model.id}" />
          <div class="mb-3">
            <textarea class="form-control" name="content" rows="3" placeholder="Viết bình luận của bạn..."></textarea>
          </div>
          <button type="submit" class="btn btn-primary">Gửi bình luận</button>
        </form>
      </section>


      <section class="py-5 bg-light">
        <div class="row">
          <c:forEach var="item" items="${model.listResult}">
            <div class="col-lg-4 col-md-4 mb-4">
              <div class="card h-100 shadow-sm border-0">
                <c:url var="itemURL" value="/item-anime">
                  <c:param name="id" value="${item.id}" />
                </c:url>
                <a href="${itemURL}">
                  <img class="card-img-top img-fluid" src="${item.thumbnail}" alt="${item.title}"
                    style="height:250px; object-fit:cover;">
                </a>
                <div class="card-body text-center d-flex flex-column justify-content-between">
                  <h5 class="card-title mb-2">
                    <a href="${itemURL}" class="text-dark fw-bold">${item.title}</a>
                  </h5>
                  <p class="card-text text-muted small"
                    style="height: 60px; overflow: hidden; text-overflow: ellipsis;">
                    ${item.shortDescription}
                  </p>
                  <div class="mb-2">
                    <c:forEach begin="1" end="5" var="star">
                      <c:choose>
                        <c:when test="${star <= item.rating}">
                          <i class="bi bi-star-fill text-warning"></i>
                        </c:when>
                        <c:otherwise>
                          <i class="bi bi-star text-warning"></i>
                        </c:otherwise>
                      </c:choose>
                    </c:forEach>
                  </div>
                </div>
                <div class="card-footer bg-transparent border-0 text-center">
                  <a href="${itemURL}" class="btn btn-outline-primary btn-sm">Xem chi tiết</a>
                </div>
              </div>
            </div>
          </c:forEach>
        </div>
      </section>
    </body>

    </html>