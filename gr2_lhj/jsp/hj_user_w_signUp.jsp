<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumBarunGothic@latest/nanumbarungothicsubset.css">
    <link rel="stylesheet" href="../css/hj_user_w_signUp.css">
    <link rel="stylesheet" href="../css/toastr.css">
    <title>Document</title>
    <style>
        *{
            font-family: 'NanumBarunGothic', sans-serif;
        }
    </style>
    <script src="../js/jquery.js"></script>
    <script src="../js/toastr.js"></script>
</head>
<body>
    <div id='form-wrap'>
    <h1>회원가입</h1>
    <form action="">
        <input id="input-id" type="text" name="id" placeholder="아이디" required>
        <input id="pass-first" type="password" name="pass" placeholder="비밀번호" required>
        <input id="pass-valid" type="password" placeholder="비밀번호확인" required>
        <input id="e-mail" type="text" name="email" placeholder="이메일" required>
        <input type="text" name="name" placeholder="이름" required>
        <input type="text" name="address" placeholder="주소" required>
        <h2>프로필이미지를 등록해주세요</h2>
        <div class="profile-wrap">
            <img id="profile-img" src="../img/signup/user.png" alt="프로필이미지">
            <input id="img-upload" type="file" name="img-file" accept="image/gif,image/jpeg,image/png" />
        </div>
        
        <h2>관심카테고리를 3개 선택해주세요</h2>
        <div class="category-wrap">
        <select name="category1">
            <option value="IT기술">IT기술</option>
            <option value="스포츠">스포츠</option>
            <option value="건강">건강</option>
            <option value="음식">음식</option>
            <option value="음악">음악</option>
            <option value="가족">가족</option>
            <option value="언어문화">언어/문화</option>
            <option value="영상제작">영상제작</option>
            <option value="기타">기타</option>
        </select>
        <select name="category2">
            <option value="IT기술">IT기술</option>
            <option value="스포츠">스포츠</option>
            <option value="건강">건강</option>
            <option value="음식">음식</option>
            <option value="음악">음악</option>
            <option value="가족">가족</option>
            <option value="언어문화">언어/문화</option>
            <option value="영상제작">영상제작</option>
            <option value="기타">기타</option>
        </select>
        <select name="category3">
            <option value="IT기술">IT기술</option>
            <option value="스포츠">스포츠</option>
            <option value="건강">건강</option>
            <option value="음식">음식</option>
            <option value="음악">음악</option>
            <option value="가족">가족</option>
            <option value="언어문화">언어/문화</option>
            <option value="영상제작">영상제작</option>
            <option value="기타">기타</option>
        </select>
        </div>
        <button type="submit">회원가입</button>
    </form>
    </div>

    <script src="../js/hj_user_w_signUp.js"></script>
</body>
</html>